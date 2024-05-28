import { Injectable } from '@nestjs/common';
import { IRepository } from 'src/components/base/repository.base';
import { InjectRepository } from '@nestjs/typeorm';
import { MongoRepository } from 'typeorm';
import { SpecialtyDocument } from '../Specialty.document';

@Injectable()
export class SpecialtyRepository implements IRepository<SpecialtyDocument> {

    constructor(
        @InjectRepository(SpecialtyDocument) private repository: MongoRepository<SpecialtyDocument>
    ) {
    }

    findAll(query?: any): Promise<SpecialtyDocument[]> {
        return this.repository.find(query);
    }

    create(document: SpecialtyDocument): Promise<SpecialtyDocument> {
        return this.repository.save(document);
    }

    findById(id: string): Promise<SpecialtyDocument> {
        return this.repository.findOne({
            where: { _id: id }
        })
    }

    findOne(query: any): Promise<SpecialtyDocument> {
        return this.repository.findOne({
            where: query
        })
    }

    update(id: string, document: SpecialtyDocument): Promise<any> {
        return this.repository.update(id, document);

    }

    remove(id: string): Promise<any> {
        return this.repository.delete(id);
    }
} 